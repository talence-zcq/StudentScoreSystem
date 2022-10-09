var pointandlinestatus=(function(){
    var st={};
    st.cv=document.createElement('canvas');
    st.cv.width=window.innerWidth;
    st.cv.height=window.innerHeight;
    st.cv.style="background:#f8f8f8;position:fixed;left:0px;top:0px;z-index:-2147483648";
    document.body.appendChild(st.cv);
    st.ctx=st.cv.getContext('2d');
    st.bouncepoint=true;
    st.p=[];
    st.sump=24;
    st.graph=[];
    st.density=0.8;
    st.init=function(){
        var i1,i2;
        st.p=[];
        var ran=Math.random;
        for(i1=0;i1<st.sump;++i1){
            st.p[i1]={x:ran(),y:ran(),v:(ran()*ran())*0.233,rot:ran()*2*Math.PI};
        }
        st.bouncepoint=(ran()<0.5);
        function makegraph(){
            var i1,i2,i3;
            for(i1=st.sump-1;i1>=0;--i1)st.graph[i1]=[];
            var i4={};
            for(i1=1;i1<st.sump;++i1){
                if(ran()<0.3)continue;
                i2=i1-1;
                i4[i1+','+i2]=true;
                st.graph[i1].push(i2);st.graph[i2].push(i1);
            }
            for(i1=Math.round(st.sump*st.density*(ran()+0.5));i1>0;--i1){
                i2=Math.floor(st.sump*ran());
                i3=((i2-1)&i2);
                if((i2==i3)||(i4[i2+','+i3]))continue;
                i4[i2+','+i3]=true;
                st.graph[i2].push(i3);st.graph[i3].push(i2);
            }
            console.log(i4);
            if(st.graph[0].length<=0){
                i2=st.sump-1;
                i4[i2+',0']=true;
                st.graph[0].push(i2);st.graph[i2].push(0);
            }
            for(i1=1;i1<st.sump;++i1){
                if(st.graph[i1].length>0)continue;
                i2=i1-1;
                i4[i1+','+i2]=true;
                st.graph[i1].push(i2);st.graph[i2].push(i1);
            }
            return;
        }
        makegraph();
        return;
    }
    st.init();
    st.drawpoint=function(i1,i2){st.ctx.fillRect(i1-1.5,i2-1.5,3,3);}
    st.linkpoint=function(i1,i2,i3,i4,i5){
        st.ctx.strokeStyle='rgba(102,204,255,'+i5+')';
        st.ctx.beginPath();
        st.ctx.moveTo(i1,i2);
        st.ctx.lineTo(i3,i4);
        st.ctx.stroke();
        return;
    }
    st.mousex=st.cv.width/2;
    st.mousey=st.cv.height/2;
    st.mouseg=0.01;
    window.onmousemove=st.msm=function(e){st.mousex=e.clientX;st.mousey=e.clientY;}
    window.onmousedown=st.msd=function(e){if(e.button==1)st.init();else st.mouseg=st.sump;}
    window.onmouseup=st.msu=function(e){st.mouseg=0;}
    st.gravity=1;
    st.f1=function(x0){
        return Math.sqrt(x0)-0.1;
    }
    st.steplen=0.001;
    function update(){
        var w1=window.innerWidth;
        if(st.cv.width!=w1)st.cv.width=w1;
        var h1=window.innerHeight;
        if(st.cv.height!=h1)st.cv.height=h1;
        st.ctx.fillStyle='#369';
        st.ctx.lineCap='round';
        st.ctx.lineWidth=8/Math.sqrt(st.p.length+1);
        st.ctx.clearRect(0,0,w1,h1);
        var l1=Math.sqrt(w1*w1+h1*h1);
        var i1,j1,i2,i3,i4,i5;
        var p=st.p;
        function getacc(res,x1,x2,linkval,grav=1,func){
            if(!func)func=st.f1;
            var i1,i2,i3;
            i1=Math.pow((x1.x-x2.x)*w1,2);
            i2=Math.pow((x1.y-x2.y)*h1,2);
            if(i1<0.000001&&i2<0.000001)i1=i2=0.000001;
            i3=grav*st.gravity*func((i1+i2)/(l1*l1))*l1;
            res[0]+=i3*(x2.x-x1.x)*w1/Math.sqrt(i1+i2);
            res[1]+=i3*(x2.y-x1.y)*h1/Math.sqrt(i1+i2);
            if(linkval>=0){
                i3=20*Math.sqrt(i1+i2)/l1;
                if(i3<1)i3=1;
                st.linkpoint(x1.x*w1,x1.y*h1,x2.x*w1,x2.y*h1,linkval/i3);
            }
            return res;
        }
        for(i1=0;i1<p.length;++i1){
            i3=st.graph[i1].reduce(function(res,x0){
                return getacc(res,p[i1],p[x0],i1>x0?0.8:-1);
            },[0,0]);
            for(i2=1;i2<=3;++i2){
                getacc(i3,p[i1],p[Math.floor(Math.random()*st.sump)],-1,-0.01,function(x){return 0.005/Math.sqrt(x+0.001);});
            }
            i2=getacc(i3,p[i1],{x:st.mousex/w1,y:st.mousey/h1},st.sump>16?3.2/st.sump:0.2,st.mouseg);
            i4=p[i1].v*l1*Math.cos(p[i1].rot);
            i5=p[i1].v*l1*Math.sin(p[i1].rot);
            i4+=i2[0];
            i5+=i2[1];
            p[i1].v=Math.sqrt(i4*i4+i5*i5)/l1;
            p[i1].rot=Math.atan2(i5,i4);
        }
        i4=0;
        for(i1=0;i1<p.length;++i1){
            i2=p[i1].x*w1;
            i3=p[i1].y*h1;
            st.drawpoint(i2,i3);
            i2+=p[i1].v*st.steplen*l1*Math.cos(p[i1].rot);
            i3+=p[i1].v*st.steplen*l1*Math.sin(p[i1].rot);
            if(st.bouncepoint){
                if(i2>w1)i2=w1,p[i1].rot=Math.PI-p[i1].rot;
                else if(i2<0)i2=0,p[i1].rot=Math.PI-p[i1].rot;
                if(i3>h1)i3=h1,p[i1].rot=-p[i1].rot;
                else if(i3<0)i3=0,p[i1].rot=-p[i1].rot;
            }else{
                if(i2>w1)i2=0;
                else if(i2<0)i2=w1;
                if(i3>h1)i3=0;
                else if(i3<0)i3=h1;
            }
            p[i1].x=i2/w1;
            p[i1].y=i3/h1;
            if(Math.random()*Math.sqrt(p[i1].v+0.01)<0.0001){
                p[i1].v+=0.5+Math.random()
                if(Math.random()<0.5)p[i1].rot+=2.6415926+Math.random();
            }
            if(p[i1].v>1)p[i1].v*=0.95;
            else if(p[i1].v>0.1)p[i1].v*=0.99;
            i4+=p[i1].v;
        }
        if(Math.random()<0.00233)console.log(i4/p.length);
        requestAnimationFrame(update);
    }
    update();
    return st;
})();

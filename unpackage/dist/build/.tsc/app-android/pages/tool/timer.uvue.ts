const __sfc__ = defineComponent({
  __name: 'timer',
  setup(__props): any | null {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	function padWithZeros(num:number, length:number) {
	    let numStr = num.toString();
	    let zerosToPad = length - numStr.length;
	    if (zerosToPad > 0) {
	        numStr = '0'.repeat(zerosToPad) + numStr;
	    }
	    return numStr;
	}
	let totalmsec=ref(5000)
	let sec=computed(()=>Math.floor(totalmsec.value/1000))
	let msec=computed(()=>totalmsec.value%1000)
	let timerdelay:number=2;
	let intervalID:number=-1
	let tid=-1;
	let settingtime=totalmsec.value;
	let isStart=false;
	let firsttouch=true;
	let showsec=computed(()=>padWithZeros(sec.value as number,2));
	let showmsec=computed(()=>padWithZeros(msec.value as number ,3));

function stop()
{
	clearInterval(intervalID);
	return true;
}
function playaudio(url:string)
{  
	let audio=uni.createInnerAudioContext();
	audio.src=(url)
	console.log(1)
	//audio.autoplay=true;
	audio.play()
	audio.onEnded(()=>
	{
		audio.destroy()
	})
}
function start()
{
	isStart=!isStart;
	
	if(firsttouch)
	{
		if(totalmsec.value<=0)
		{
			totalmsec.value=settingtime;
		}
		console.log(3)
	  playaudio('/static/voice/计时开始了呦.wav')
	  firsttouch=false
	}
	else{
		
	
	}
	if(isStart)
	{intervalID=setInterval(
	()=>{
	totalmsec.value=totalmsec.value-timerdelay>=0?totalmsec.value-timerdelay:0;

	if(totalmsec.value==0)
	{
			stop()
			console.log(1)
			 if (tid != -1) {
			    clearTimeout(tid) 
			}
			tid=setTimeout(()=>{playaudio('/static/voice/计时结束.wav')},50)
		
			firsttouch=true;
			isStart=false;
			return
	}
	
	}
	,timerdelay);}
	else
	{if(!firsttouch){
		playaudio('/static/voice/暂停.wav')
		}
		clearInterval(intervalID);}
}

function changeTime()
{
	let op:ShowModalOptions={title:'修改时间（单位：秒）',
	                         editable:true,
							 fail:null,
							 success:(res)=>{
								 if(res.cancel)
								 {return}
								 console.log('我成功了');
								let content=res.content?.trim();
								let a=parseInt(content!)
								if(a==NaN||a<0)
								{
									uni.showToast({
									          title: "请输入正整数",
											  icon:'none',
											  position:'bottom'
									        })
									return
								}
								else{
									totalmsec.value=a*1000;
									settingtime=a*1000;
								}
							
							 },
							 
							 };
	let a=uni.showModal(op)
	
}

return (): any | null => {

const _component_navigator = resolveComponent("navigator")

  return createElementVNode("view", utsMapOf({ class: "timer" }), [
    createVNode(_component_navigator, utsMapOf({
      "open-type": "navigateBack",
      "animation-type": "pop-out",
      url: "/pages/index/index",
      class: "Exit"
    }), utsMapOf({
      default: withSlotCtx((): any[] => [
        createElementVNode("text", utsMapOf({
          selectable: "false",
          class: "ExitText"
        }), "< 返回")
      ]),
      _: 1 /* STABLE */
    })),
    createElementVNode("text", utsMapOf({
      onClick: () => {start()},
      class: "timertext"
    }), toDisplayString(unref(showsec)) + ":" + toDisplayString(unref(showmsec)), 9 /* TEXT, PROPS */, ["onClick"]),
    createElementVNode("text", utsMapOf({
      onClick: () => {changeTime()},
      class: "settimertext"
    }), " 设置时间", 8 /* PROPS */, ["onClick"])
  ])
}
}

})
export default __sfc__
const GenPagesToolTimerStyles = [utsMapOf([["timer", padStyleMapOf(utsMapOf([["height", "100%"], ["width", "100%"], ["backgroundImage", "linear-gradient(to bottom, #000000, #1A1A1A)"], ["backgroundColor", "rgba(0,0,0,0)"], ["zIndex", -1], ["display", "flex"], ["flexDirection", "column"], ["alignItems", "center"], ["justifyContent", "center"], ["flexWrap", "wrap"]]))], ["Exit", utsMapOf([[".timer ", utsMapOf([["zIndex", 200], ["position", "fixed"], ["marginLeft", "5%"], ["marginTop", "3%"], ["width", 100], ["height", 50]])]])], ["ExitText", utsMapOf([[".timer .Exit ", utsMapOf([["fontFamily", "像素字"], ["color", "#FFFFFF"], ["fontSize", 30], ["textAlign", "left"]])]])], ["timertext", utsMapOf([[".timer ", utsMapOf([["fontFamily", "像素字"], ["fontSize", 50], ["color", "#F5DEB3"]])]])], ["settimertext", utsMapOf([[".timer ", utsMapOf([["fontFamily", "像素字"], ["fontSize", 35], ["color", "#FFFFFF"], ["zIndex", 1], ["position", "fixed"], ["right", 30], ["bottom", 5], ["marginTop", "4%"], ["height", 50]])]])], ["@FONT-FACE", utsMapOf([["0", utsMapOf([["fontFamily", "像素字"], ["src", "url(\"../static/锐字太空奇遇像素.ttf\")"]])]])]])]

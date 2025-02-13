const __sfc__ = defineComponent({
  __name: 'index',
  setup(__props): any | null {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	
	let info=uni.getStorageInfoSync()
	let initkey=['真心话','大冒险','自定义1','自定义2']
	let initword=[
		['你人生中最尴尬的时刻是什么时候','你心中有没有一个一直不敢表白的人？','什么类型的现实/虚拟人物最符合你的口味,详细说一下吸引你的原因'
		,'简单说一下你对在场所有人的真实看法','你的初恋是在什么时候,讲一讲你们之间的故事','如果你可以回到过去，你最想改变什么','你是否有过“自我安慰"的经历，第一次是什么时候',
		'你见到过/梦到过最离谱的事情是什么','你人生最后悔的一件事是什么','你有没有不为人知的小癖好？','假如你的生命还剩24小时,你会做什么',
		'你最喜欢的动漫/影视作品是什么','你觉得你最大的优点是什么','你人生中最大的愿望是什么'],
		['不张嘴唱歌，让其他人猜出歌名','下一轮游戏中，你说的每句话末尾都要加<喵~>','含一口水跟任意一人对视15秒，保持住不笑场','声情并茂的朗读一段发癫文案'
		,'被在场的所有人弹一次脑瓜崩(不足5人则次数翻倍)','头像换成奶龙,并发一条与之相关的说说','模仿任意明星/主播/动漫人物，并让大家猜出来','大象鼻子转圈10秒，并绕场走一周'
		,'跟列表中的一个人假装表白','录制一段才艺视频/手元，并发到QQ空间','与在场的任意1人拥抱15秒','下一局游戏中，你说的每一句话要与你所想表达的意思相反','背诵一首较长的古诗'
		,'下一局游戏中，尽可能的用方言/外语进行交流','手腕扭过来反手喝几口水'],
		['自定义文本1'],
		['自定义文本2'],
	]
	console.log(info)
	let i=0;
	//if(!(info.keys.includes('initkey')))
	//{uni.setStorageSync('initkey',initkey)}
	for(let item of initkey){
	if(!(info.keys.includes(item)))
	{
		//let initlist=['真心话','大冒险']
		//let initlist=['下一轮游戏中每局话结尾必须跟<喵~>,否则摸一张牌','大冒险']
		uni.setStorageSync(item,initword[i])
		i++
	}
	}

return (): any | null => {

const _component_navigator = resolveComponent("navigator")

  return createElementVNode("view", utsMapOf({ class: "index" }), [
    createElementVNode("text", utsMapOf({ class: "menutitle" }), " 真心话大冒险"),
    createElementVNode("view", utsMapOf({ class: "menubox" }), [
      createVNode(_component_navigator, utsMapOf({
        url: "/pages/game/start",
        class: "menubtn"
      }), utsMapOf({
        default: withSlotCtx((): any[] => [
          createElementVNode("view", utsMapOf({ class: "menunav" }), [
            createElementVNode("image", utsMapOf({
              src: "/static/start.png",
              class: "menuimg"
            })),
            createElementVNode("text", utsMapOf({ class: "menutext" }), " 开始游戏 ")
          ])
        ]),
        _: 1 /* STABLE */
      })),
      createVNode(_component_navigator, utsMapOf({
        url: "/pages/game/setting",
        class: "menubtn"
      }), utsMapOf({
        default: withSlotCtx((): any[] => [
          createElementVNode("view", utsMapOf({ class: "menunav" }), [
            createElementVNode("image", utsMapOf({
              src: "/static/set.png",
              class: "menuimg2"
            })),
            createElementVNode("text", utsMapOf({ class: "menutext" }), " 设置词条 ")
          ])
        ]),
        _: 1 /* STABLE */
      })),
      createVNode(_component_navigator, utsMapOf({
        url: "/pages/tool/menu",
        class: "menubtn"
      }), utsMapOf({
        default: withSlotCtx((): any[] => [
          createElementVNode("view", utsMapOf({ class: "menunav" }), [
            createElementVNode("image", utsMapOf({
              src: "/static/工具箱.png",
              class: "menuimg2"
            })),
            createElementVNode("text", utsMapOf({ class: "menutext" }), " 工具箱 ")
          ])
        ]),
        _: 1 /* STABLE */
      }))
    ])
  ])
}
}

})
export default __sfc__
const GenPagesIndexIndexStyles = [utsMapOf([["index", padStyleMapOf(utsMapOf([["height", "100%"], ["width", "100%"], ["backgroundImage", "linear-gradient(to bottom, #000000, #1A1A1A)"], ["backgroundColor", "rgba(0,0,0,0)"], ["zIndex", -1], ["display", "flex"], ["flexDirection", "column"], ["alignItems", "center"], ["justifyContent", "center"]]))], ["menubox", utsMapOf([[".index ", utsMapOf([["height", "70%"], ["width", "75%"], ["display", "flex"], ["flexDirection", "row"], ["justifyContent", "center"], ["alignItems", "center"], ["borderRadius", 15], ["borderWidth", 1], ["borderStyle", "solid"], ["borderColor", "#1A1A1A"]])]])], ["menubtn", utsMapOf([[".index .menubox ", utsMapOf([["paddingTop", 35], ["borderRadius", 35], ["marginLeft", 10], ["marginRight", 10], ["height", "90%"], ["borderWidth", 3], ["borderStyle", "solid"], ["borderColor", "#e91e63"], ["boxSizing", "border-box"], ["flex", 1]])]])], ["menutext", utsMapOf([[".index .menubox .menubtn .menunav ", utsMapOf([["fontSize", 30], ["textAlign", "center"], ["color", "#e91e63"], ["fontFamily", "像素字"]])]])], ["menuimg", utsMapOf([[".index .menubox .menubtn .menunav ", utsMapOf([["width", 110], ["height", 110], ["justifySelf", "center"], ["alignSelf", "center"], ["transform", "translateX(-5%) translateY(3%) scale(1.05, 1.05)"]])]])], ["menuimg2", utsMapOf([[".index .menubox .menubtn .menunav ", utsMapOf([["width", 120], ["height", 120], ["transform", "translateY(-2%) scale(0.85, 0.85)"], ["justifySelf", "center"], ["alignSelf", "center"]])]])], ["menutitle", padStyleMapOf(utsMapOf([["transform", "translateY(-25%) translateX(-3%)"], ["maxHeight", 50], ["fontSize", 50], ["textAlign", "center"], ["color", "#FFFFFF"], ["fontFamily", "像素字"]]))], ["@FONT-FACE", utsMapOf([["0", utsMapOf([["fontFamily", "像素字"], ["src", "url(\"../static/锐字太空奇遇像素.ttf\")"]])]])]])]

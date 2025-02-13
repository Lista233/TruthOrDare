const __sfc__ = defineComponent({
  __name: 'setting',
  setup(__props): any | null {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	//uni.clearStorageSync()
	let keylist=uni.getStorageInfoSync().keys;
	let curshow=ref(keylist[0])
	let list=uni.getStorageSync(curshow.value) as Array<string>
	let wordList=ref(list)
	let addword=ref('')
	let audio=uni.createInnerAudioContext();
//console.log(list)
function changeword(res:UniInputConfirmEvent,index:number)
{
	wordList.value[index]=res.detail.value;
	uni.setStorageSync(curshow.value,wordList.value)
	uni.showToast({
	          title: "修改成功",
			  icon:'none',
			  position:'bottom'
	        })
}
function add(word:string)
{
	
	if(word.trim().length === 0)
	{
		uni.showToast({
		          title: "输入内容不能为空",
				  icon:'none',
				  position:'bottom'
		        })
		return;
	}
	wordList.value.push(word)
	uni.setStorageSync(curshow.value,wordList.value)
	uni.showToast({
	          title: "添加成功",
			  icon:'none',
			  position:'bottom'
	        })
	addword.value='';
}
function del(index:number)
{
	wordList.value.splice(index,1)
	uni.showToast({
	          title: "为防止误删，保存后删除生效",
			  icon:'none',
			  position:'bottom'
	        })
}
function save()
{
	
	uni.setStorageSync(curshow.value,wordList.value)
	console.log("保存成功")
	uni.showToast({
	          title: "保存成功",
			  icon:'none',
			  position:'bottom'
	        })
}
function showList()
{
	
	let op:ShowActionSheetOptions={
	  //title:'词条选项',
	  itemList:keylist,
	  success:(res)=>{
		  curshow.value=keylist[res.tapIndex!]
		  wordList.value=uni.getStorageSync(curshow.value) as Array<string>
	  }
	  
	}
	uni.showActionSheet(op);
}

return (): any | null => {

const _component_navigator = resolveComponent("navigator")

  return createElementVNode("view", utsMapOf({ class: "demo3" }), [
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
    createElementVNode("scroll-view", utsMapOf({
      class: "showscrollview",
      "scroll-y": "true"
    }), [
      createElementVNode(Fragment, null, RenderHelpers.renderList(unref(wordList), (item, index, __index, _cached): any => {
        return createElementVNode("view", utsMapOf({ class: "showview" }), [
          createElementVNode("input", utsMapOf({
            class: "textbox",
            value: item,
            onInput: (res:UniInputConfirmEvent)=> changeword(res,index)
          }), null, 40 /* PROPS, NEED_HYDRATION */, ["value", "onInput"]),
          createElementVNode("text", utsMapOf({
            class: "textboxdel",
            onClick: () => {del(index)}
          }), " 删除 ", 8 /* PROPS */, ["onClick"])
        ])
      }), 256 /* UNKEYED_FRAGMENT */)
    ]),
    createElementVNode("view", utsMapOf({ class: "inputbox" }), [
      createElementVNode("input", utsMapOf({
        class: "showinput",
        placeholder: "请输入添加的内容",
        modelValue: unref(addword),
        onInput: ($event: InputEvent) => {addword = trySetRefValue(addword, $event.detail.value)},
        "adjust-position": "true"
      }), null, 40 /* PROPS, NEED_HYDRATION */, ["modelValue"]),
      createElementVNode("button", utsMapOf({
        class: "subbtn",
        onClick: () => {add(unref(addword))}
      }), "添加", 8 /* PROPS */, ["onClick"])
    ]),
    createElementVNode("view", utsMapOf({
      class: "Save",
      onClick: () => {save()}
    }), [
      createElementVNode("text", utsMapOf({ class: "SaveText" }), "保存")
    ], 8 /* PROPS */, ["onClick"]),
    createElementVNode("view", utsMapOf({
      class: "sel",
      onClick: () => {showList()}
    }), [
      createElementVNode("text", utsMapOf({ class: "selText" }), "当前列表:" + toDisplayString(unref(curshow)), 1 /* TEXT */)
    ], 8 /* PROPS */, ["onClick"])
  ])
}
}

})
export default __sfc__
const GenPagesGameSettingStyles = [utsMapOf([["demo3", padStyleMapOf(utsMapOf([["height", "100%"], ["width", "100%"], ["backgroundImage", "linear-gradient(to bottom, #000000, #1A1A1A)"], ["backgroundColor", "rgba(0,0,0,0)"], ["display", "flex"], ["alignItems", "center"], ["justifyContent", "center"], ["zIndex", -1]]))], ["Exit", utsMapOf([[".demo3 ", utsMapOf([["zIndex", 200], ["position", "fixed"], ["marginLeft", "5%"], ["marginTop", "3%"], ["width", 100], ["height", 50]])]])], ["ExitText", utsMapOf([[".demo3 .Exit ", utsMapOf([["fontFamily", "像素字"], ["color", "#FFFFFF"], ["fontSize", 30], ["textAlign", "left"]])]])], ["Save", utsMapOf([[".demo3 ", utsMapOf([["zIndex", 1], ["position", "fixed"], ["right", "8%"], ["marginTop", "3%"], ["width", 100], ["height", 50]])]])], ["SaveText", utsMapOf([[".demo3 .Save ", utsMapOf([["fontFamily", "像素字"], ["color", "#FFFFFF"], ["fontSize", 30], ["textAlign", "center"]])]])], ["sel", utsMapOf([[".demo3 ", utsMapOf([["zIndex", 1], ["position", "fixed"], ["right", "35%"], ["marginTop", "3%"], ["width", 300], ["height", 50]])]])], ["selText", utsMapOf([[".demo3 .sel ", utsMapOf([["fontFamily", "像素字"], ["color", "#FFFFFF"], ["fontSize", 30], ["textAlign", "center"]])]])], ["showview", utsMapOf([[".demo3 ", utsMapOf([["borderBottomWidth", 2], ["borderBottomStyle", "solid"], ["borderBottomColor", "#1A1A1A"], ["width", "100%"], ["backgroundColor", "#FFFFFF"], ["display", "flex"], ["flexDirection", "row"], ["position", "relative"]])]])], ["textbox", utsMapOf([[".demo3 .showview ", utsMapOf([["flex", 1], ["textAlign", "left"], ["fontFamily", "像素字"], ["fontSize", 25]])]])], ["textboxdel", utsMapOf([[".demo3 .showview ", utsMapOf([["borderLeftWidth", 2], ["borderLeftStyle", "solid"], ["borderLeftColor", "#000000"], ["textAlign", "right"], ["fontFamily", "像素字"], ["fontSize", 30], ["color", "#FF0000"]])]])], ["showscrollview", utsMapOf([[".demo3 ", utsMapOf([["marginTop", "5%"], ["height", "57%"], ["width", "80%"], ["backgroundColor", "#FFFFFF"], ["position", "relative"]])]])], ["inputbox", utsMapOf([[".demo3 ", utsMapOf([["marginTop", "3%"], ["width", "80%"], ["display", "flex"], ["flexDirection", "row"], ["height", 60]])]])], ["showinput", utsMapOf([[".demo3 .inputbox ", utsMapOf([["height", "100%"], ["width", "84%"], ["marginRight", "2%"], ["textAlign", "left"], ["backgroundColor", "#F5DEB3"], ["fontFamily", "像素字"]])]])], ["subbtn", utsMapOf([[".demo3 .inputbox ", utsMapOf([["fontFamily", "像素字"], ["height", "100%"], ["width", "15%"], ["backgroundColor", "#0000FF"], ["paddingTop", 7], ["paddingRight", 7], ["paddingBottom", 7], ["paddingLeft", 7], ["color", "#FFFFFF"], ["boxSizing", "border-box"]])]])], ["@FONT-FACE", utsMapOf([["0", utsMapOf([["fontFamily", "像素字"], ["src", "url(\"../static/锐字太空奇遇像素.ttf\")"]])]])]])]

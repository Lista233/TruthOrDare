const __sfc__ = defineComponent({})
export default __sfc__
function GenPagesToolMenuRender(this: InstanceType<typeof __sfc__>): any | null {
const _ctx = this
const _cache = this.$.renderCache
const _component_navigator = resolveComponent("navigator")

  return createElementVNode("view", utsMapOf({ class: "index" }), [
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
    createElementVNode("text", utsMapOf({ class: "menutitle" }), " 工具箱"),
    createElementVNode("view", utsMapOf({ class: "menubox" }), [
      createVNode(_component_navigator, utsMapOf({
        url: "/pages/tool/timer",
        class: "menubtn"
      }), utsMapOf({
        default: withSlotCtx((): any[] => [
          createElementVNode("view", utsMapOf({ class: "menunav" }), [
            createElementVNode("image", utsMapOf({
              src: "/static/计时器.png",
              class: "menuimg"
            })),
            createElementVNode("text", utsMapOf({ class: "menutext" }), " 计时器 ")
          ])
        ]),
        _: 1 /* STABLE */
      })),
      createVNode(_component_navigator, utsMapOf({
        url: "/pages/tool/voicer",
        class: "menubtn"
      }), utsMapOf({
        default: withSlotCtx((): any[] => [
          createElementVNode("view", utsMapOf({ class: "menunav" }), [
            createElementVNode("image", utsMapOf({
              src: "/static/声音.png",
              class: "menuimg2"
            })),
            createElementVNode("text", utsMapOf({ class: "menutext" }), " 嘴替 ")
          ])
        ]),
        _: 1 /* STABLE */
      }))
    ])
  ])
}
const GenPagesToolMenuStyles = [utsMapOf([["index", padStyleMapOf(utsMapOf([["height", "100%"], ["width", "100%"], ["backgroundImage", "linear-gradient(to bottom, #000000, #1A1A1A)"], ["backgroundColor", "rgba(0,0,0,0)"], ["zIndex", -1], ["display", "flex"], ["flexDirection", "column"], ["alignItems", "center"], ["justifyContent", "center"], ["flexWrap", "wrap"]]))], ["Exit", utsMapOf([[".index ", utsMapOf([["zIndex", 200], ["position", "fixed"], ["marginLeft", "5%"], ["marginTop", "3%"], ["width", 100], ["height", 50]])]])], ["ExitText", utsMapOf([[".index .Exit ", utsMapOf([["fontFamily", "像素字"], ["color", "#FFFFFF"], ["fontSize", 30], ["textAlign", "left"]])]])], ["menubox", utsMapOf([[".index ", utsMapOf([["height", "70%"], ["width", "75%"], ["display", "flex"], ["flexDirection", "row"], ["justifyContent", "center"], ["alignItems", "center"], ["borderRadius", 15], ["borderWidth", 1], ["borderStyle", "solid"], ["borderColor", "#1A1A1A"]])]])], ["menubtn", utsMapOf([[".index .menubox ", utsMapOf([["paddingTop", 35], ["borderRadius", 35], ["marginLeft", 10], ["marginRight", 10], ["height", "90%"], ["borderWidth", 3], ["borderStyle", "solid"], ["borderColor", "#e91e63"], ["boxSizing", "border-box"], ["flex", 1]])]])], ["menutext", utsMapOf([[".index .menubox .menubtn .menunav ", utsMapOf([["fontSize", "30rpx"], ["textAlign", "center"], ["color", "#e91e63"], ["fontFamily", "像素字"]])]])], ["menuimg", utsMapOf([[".index .menubox .menubtn .menunav ", utsMapOf([["width", "110rpx"], ["height", "110rpx"], ["justifySelf", "center"], ["alignSelf", "center"], ["transform", "translateX(-5%) translateY(3%) scale(0.85, 0.85)"]])]])], ["menuimg2", utsMapOf([[".index .menubox .menubtn .menunav ", utsMapOf([["width", "110rpx"], ["height", "110rpx"], ["transform", "translateY(2%) scale(1, 1)"], ["justifySelf", "center"], ["alignSelf", "center"]])]])], ["menutitle", padStyleMapOf(utsMapOf([["transform", "translateY(-25%) translateX(-3%)"], ["maxHeight", 50], ["fontSize", 50], ["textAlign", "center"], ["color", "#FFFFFF"], ["fontFamily", "像素字"]]))], ["@FONT-FACE", utsMapOf([["0", utsMapOf([["fontFamily", "像素字"], ["src", "url(\"../static/锐字太空奇遇像素.ttf\")"]])]])]])]

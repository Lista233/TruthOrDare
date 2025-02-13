@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER")
package uni.UNI00DFA61;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.unicloud.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import io.dcloud.uniapp.extapi.getStorageInfoSync as uni_getStorageInfoSync;
import io.dcloud.uniapp.extapi.setStorageSync as uni_setStorageSync;
open class GenPagesIndexIndex : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesIndexIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenPagesIndexIndex;
            val _cache = __ins.renderCache;
            var info = uni_getStorageInfoSync();
            var initkey = utsArrayOf(
                "真心话",
                "大冒险",
                "自定义1",
                "自定义2"
            );
            var initword = utsArrayOf(
                utsArrayOf(
                    "你人生中最尴尬的时刻是什么时候",
                    "你心中有没有一个一直不敢表白的人？",
                    "什么类型的现实/虚拟人物最符合你的口味,详细说一下吸引你的原因",
                    "简单说一下你对在场所有人的真实看法",
                    "你的初恋是在什么时候,讲一讲你们之间的故事",
                    "如果你可以回到过去，你最想改变什么",
                    "你是否有过“自我安慰\"的经历，第一次是什么时候",
                    "你见到过/梦到过最离谱的事情是什么",
                    "你人生最后悔的一件事是什么",
                    "你有没有不为人知的小癖好？",
                    "假如你的生命还剩24小时,你会做什么",
                    "你最喜欢的动漫/影视作品是什么",
                    "你觉得你最大的优点是什么",
                    "你人生中最大的愿望是什么"
                ),
                utsArrayOf(
                    "不张嘴唱歌，让其他人猜出歌名",
                    "下一轮游戏中，你说的每句话末尾都要加<喵~>",
                    "含一口水跟任意一人对视15秒，保持住不笑场",
                    "声情并茂的朗读一段发癫文案",
                    "被在场的所有人弹一次脑瓜崩(不足5人则次数翻倍)",
                    "头像换成奶龙,并发一条与之相关的说说",
                    "模仿任意明星/主播/动漫人物，并让大家猜出来",
                    "大象鼻子转圈10秒，并绕场走一周",
                    "跟列表中的一个人假装表白",
                    "录制一段才艺视频/手元，并发到QQ空间",
                    "与在场的任意1人拥抱15秒",
                    "下一局游戏中，你说的每一句话要与你所想表达的意思相反",
                    "背诵一首较长的古诗",
                    "下一局游戏中，尽可能的用方言/外语进行交流",
                    "手腕扭过来反手喝几口水"
                ),
                utsArrayOf(
                    "自定义文本1"
                ),
                utsArrayOf(
                    "自定义文本2"
                )
            );
            console.log(info, " at pages/index/index.uvue:49");
            var i: Number = 0;
            for(item in resolveUTSValueIterator(initkey)){
                if (!info.keys.includes(item)) {
                    uni_setStorageSync(item, initword[i]);
                    i++;
                }
            }
            return fun(): Any? {
                val _component_navigator = resolveComponent("navigator");
                return createElementVNode("view", utsMapOf("class" to "index"), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "menutitle"), " 真心话大冒险"),
                    createElementVNode("view", utsMapOf("class" to "menubox"), utsArrayOf(
                        createVNode(_component_navigator, utsMapOf("url" to "/pages/game/start", "class" to "menubtn"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "menunav"), utsArrayOf(
                                    createElementVNode("image", utsMapOf("src" to "/static/start.png", "class" to "menuimg")),
                                    createElementVNode("text", utsMapOf("class" to "menutext"), " 开始游戏 ")
                                ))
                            );
                        }
                        ), "_" to 1)),
                        createVNode(_component_navigator, utsMapOf("url" to "/pages/game/setting", "class" to "menubtn"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "menunav"), utsArrayOf(
                                    createElementVNode("image", utsMapOf("src" to "/static/set.png", "class" to "menuimg2")),
                                    createElementVNode("text", utsMapOf("class" to "menutext"), " 设置词条 ")
                                ))
                            );
                        }
                        ), "_" to 1)),
                        createVNode(_component_navigator, utsMapOf("url" to "/pages/tool/menu", "class" to "menubtn"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "menunav"), utsArrayOf(
                                    createElementVNode("image", utsMapOf("src" to "/static/工具箱.png", "class" to "menuimg2")),
                                    createElementVNode("text", utsMapOf("class" to "menutext"), " 工具箱 ")
                                ))
                            );
                        }
                        ), "_" to 1))
                    ))
                ));
            }
            ;
        }
        ;
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ), utsArrayOf(
                GenApp.styles
            ))
        };
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("index" to padStyleMapOf(utsMapOf("height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #000000, #1A1A1A)", "backgroundColor" to "rgba(0,0,0,0)", "zIndex" to -1, "display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center")), "menubox" to utsMapOf(".index " to utsMapOf("height" to "70%", "width" to "75%", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "borderRadius" to 15, "borderWidth" to 1, "borderStyle" to "solid", "borderColor" to "#1A1A1A")), "menubtn" to utsMapOf(".index .menubox " to utsMapOf("paddingTop" to 35, "borderRadius" to 35, "marginLeft" to 10, "marginRight" to 10, "height" to "90%", "borderWidth" to 3, "borderStyle" to "solid", "borderColor" to "#e91e63", "boxSizing" to "border-box", "flex" to 1)), "menutext" to utsMapOf(".index .menubox .menubtn .menunav " to utsMapOf("fontSize" to 30, "textAlign" to "center", "color" to "#e91e63", "fontFamily" to "像素字")), "menuimg" to utsMapOf(".index .menubox .menubtn .menunav " to utsMapOf("width" to 110, "height" to 110, "justifySelf" to "center", "alignSelf" to "center", "transform" to "translateX(-5%) translateY(3%) scale(1.05, 1.05)")), "menuimg2" to utsMapOf(".index .menubox .menubtn .menunav " to utsMapOf("width" to 120, "height" to 120, "transform" to "translateY(-2%) scale(0.85, 0.85)", "justifySelf" to "center", "alignSelf" to "center")), "menutitle" to padStyleMapOf(utsMapOf("transform" to "translateY(-25%) translateX(-3%)", "maxHeight" to 50, "fontSize" to 50, "textAlign" to "center", "color" to "#FFFFFF", "fontFamily" to "像素字")), "@FONT-FACE" to utsMapOf("0" to utsMapOf("fontFamily" to "像素字", "src" to "url(\"../static/锐字太空奇遇像素.ttf\")")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}

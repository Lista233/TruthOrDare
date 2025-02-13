
	let firstBackTime = 0
	
	const __sfc__ = defineApp({
		globalData:{
			 randomlist: [] as number[]
		},
		onLaunch: function () {
			console.log('App Launch', " at App.uvue:9")
		
		},
		onShow: function () {
			console.log('App Show', " at App.uvue:13")
		},
		onHide: function () {
			console.log('App Hide', " at App.uvue:16")
		},

		onLastPageBackPress: function () {
			console.log('App LastPageBackPress', " at App.uvue:20")
			if (firstBackTime == 0) {
				uni.showToast({
					title: '再按一次退出应用',
					position: 'bottom',
				})
				firstBackTime = Date.now()
				setTimeout(() => {
					firstBackTime = 0
				}, 2000)
			} else if (Date.now() - firstBackTime < 2000) {
				firstBackTime = Date.now()
				uni.exit()
			}
		},

		onExit: function () {
			console.log('App Exit', " at App.uvue:37")
		},
	})

export default __sfc__
const GenAppStyles = [utsMapOf([["uni-row", padStyleMapOf(utsMapOf([["flexDirection", "row"]]))], ["uni-column", padStyleMapOf(utsMapOf([["flexDirection", "column"]]))]])]

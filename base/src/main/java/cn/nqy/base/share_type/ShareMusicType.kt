package cn.nqy.base.share_type

/**
 * 音乐分享模式
 *
 * @param webUrl 消息被点击后跳转的链接url
 * @param title 分享的标题
 * @param musicUrl 音乐文件的链接url
 *
 */
open class ShareMusicType(val webUrl: String, val title: String, val musicUrl: String) : IShareType
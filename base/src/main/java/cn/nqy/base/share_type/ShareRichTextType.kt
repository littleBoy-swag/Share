package cn.nqy.base.share_type

/**
 * 富文本分享模式
 *
 * @param webUrl 消息被点击后跳转的链接url
 * @param title 分享的标题
 *
 */
open class ShareRichTextType(open val webUrl: String, open val title: String) : IShareType
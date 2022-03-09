package cn.nqy.share_qq.share_type

import cn.nqy.base.share_type.ShareRichTextType

class QQShareRichTextType(
    override val webUrl: String,
    override val title: String,
    val summary: String
) : ShareRichTextType(webUrl, title)
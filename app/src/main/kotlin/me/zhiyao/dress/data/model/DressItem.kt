package me.zhiyao.dress.data.model

import me.zhiyao.dress.data.db.entity.FilterWithFilterOptions
import me.zhiyao.dress.data.db.model.Dress
import me.zhiyao.dress.data.db.model.DressImage

/**
 *
 * @author WangZhiYao
 * @date 2021/1/21
 */
data class DressItem(
    val dress: Dress,
    val imageList: List<DressImage>,
    val filterList: List<FilterWithFilterOptions>
)
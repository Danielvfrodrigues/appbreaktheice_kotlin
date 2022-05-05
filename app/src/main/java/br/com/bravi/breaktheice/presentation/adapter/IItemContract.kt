package br.com.bravi.breaktheice.presentation.adapter

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
interface IItemContract<T> {

    fun replaceList(dataSet: MutableList<T?>, init: Boolean)
}

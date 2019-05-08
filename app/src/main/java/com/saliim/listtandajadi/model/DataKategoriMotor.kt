package com.saliim.listtandajadi.model


import com.google.gson.annotations.SerializedName

class DataKategoriMotor{
	@field:SerializedName("create_by")
	val createBy: String? = null

	@field:SerializedName("batas_diskon")
	val batasDiskon: String? = null

	@field:SerializedName("created")
	val created: String? = null

	@field:SerializedName("qty")
	val qty: String? = null

	@field:SerializedName("name")
	val name: String? = ""

	@field:SerializedName("modified")
	val modified: String? = null

	@field:SerializedName("id")
	val id: String? = null

	@field:SerializedName("modi_by")
	val modiBy: String? = null

	override fun toString(): String {
		return this.name!!
	}
}



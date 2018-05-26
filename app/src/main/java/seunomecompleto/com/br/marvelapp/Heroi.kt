package seunomecompleto.com.br.marvelapp

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by logonrm on 25/05/2018.
 */
class Heroi(val nome: String,
            val imagemId: Int,
            val descricao: String,
            val forca: Int,
            val velocidade: Int,
            val equipamento: Int,
            val inteligencia: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeInt(imagemId)
        parcel.writeString(descricao)
        parcel.writeInt(forca)
        parcel.writeInt(velocidade)
        parcel.writeInt(equipamento)
        parcel.writeInt(inteligencia)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Heroi> {
        override fun createFromParcel(parcel: Parcel): Heroi {
            return Heroi(parcel)
        }

        override fun newArray(size: Int): Array<Heroi?> {
            return arrayOfNulls(size)
        }
    }
}
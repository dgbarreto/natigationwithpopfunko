package com.avanade.popfunko.datasource

import android.content.res.XmlResourceParser
import com.avanade.popfunko.model.Funko
import org.xmlpull.v1.XmlPullParser

class FunkoDataSource(val xmlData: XmlResourceParser) {
    fun getData(collection: String?) : List<Funko>{
        val output : MutableList<Funko> = mutableListOf()
        while(xmlData.eventType != XmlPullParser.END_DOCUMENT){
            if(xmlData.eventType == XmlPullParser.START_TAG && xmlData.name.equals("funko", true)){
                output.add(Funko(xmlData.getAttributeIntValue(3,1), xmlData.getAttributeValue(2),
                    xmlData.getAttributeValue(1).toString().replace("@", "").toInt(),
                    xmlData.getAttributeValue(0)))
            }
            xmlData.next()
        }

        return if(collection != "null")
            output.filter { w -> w.collection.equals(collection?.replace(" " ,""), true) }
        else
            output
    }
}
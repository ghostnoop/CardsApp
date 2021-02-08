package crd.ctin.cardstinapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class Girl(
    var name: String,
    var profession: String,
    var imageURL: String,
    var age: Int,
    var liked:Boolean,
    var message: Message
): Serializable, Parcelable


fun getGirlsAll(): List<Girl> {
    return listOf(
        Girl("Angelina","Photographer","https://i.pinimg.com/originals/1b/3c/7e/1b3c7e0a90b03101e175cf14598c41e4.jpg",23,false,Message(0, 1, "", "Angelina")),
        Girl("Sofie","AnimeTyan","https://trikky.ru/wp-content/blogs.dir/1/files/2020/03/01/0d533c829b0a3b7456814f7a4de8fa53.jpg",22,false,Message(0, 2, "", "Sofie")),
        Girl("Park Chaeyoung","TikToker","https://i.pinimg.com/564x/41/38/32/4138327414c19c0ab90632c01e4af34c.jpg",20,false,Message(0, 3, "", "Park Chaeyoung")),
        Girl("Jennie Howells","Actor","https://images.unsplash.com/photo-1520512202623-51c5c53957df?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",27,false,Message(0, 4, "", "Jennie Howells")),
        Girl("Cindy Hale","Art Director","https://images.unsplash.com/photo-1578616070222-50c4de9d5ade?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",19,false, Message(0,5,"","Cindy Hale")),
        Girl("Jorja Glenn","Artist","https://images.unsplash.com/photo-1503414265207-455bcd0955dc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",23,false, Message(0,6,"","Jorja Glenn")),
        Girl("Vivien Nixon","Auto Mechanic","https://images.unsplash.com/photo-1440589473619-3cde28941638?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",26,false, Message(0,7,"","Vivien Nixon")),
        Girl("Chantelle Whitney","Automotive mechanic","https://images.unsplash.com/photo-1467632499275-7a693a761056?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",20,false, Message(0,8,"","Chantelle Whitney")),
        Girl("Isla-Grace Firth","Bookkeeping clerk","https://images.unsplash.com/photo-1539811107033-3a67f3ebc852?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",19,false, Message(0,9,"","Isla-Grace Firth")),
        Girl("Sumayya Forster","Budget analyst","https://images.unsplash.com/photo-1502831376-280384d0fbd8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",28,false, Message(0,10,"","Sumayya Forster")),
        Girl("Renae Ramsey","Bus Driver","https://images.unsplash.com/photo-1509122043523-bc25fa2c1d6d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",28,false, Message(0,11,"","Renae Ramsey")),
        Girl("Thierry Beltran","Carpenter","https://images.unsplash.com/photo-1502982899975-893c9cf39028?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",23,false, Message(0,12,"","Thierry Beltran")),
        Girl("Tyrell Delgado","Cashier","https://images.unsplash.com/photo-1589571894960-20bbe2828d0a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",20,false, Message(0,13,"","Tyrell Delgado")),
        Girl("Dakota Davenport","Chef","https://images.unsplash.com/flagged/photo-1576212152884-614580e3d5ac?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",18,false, Message(0,14,"","Dakota Davenport")),
        Girl("Liyana Sharma","Chemist","https://images.unsplash.com/photo-1482555670981-4de159d8553b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",20,false, Message(0,15,"","Liyana Sharma")),
        Girl("Chantal Reid","Childcare worker","https://images.unsplash.com/photo-1545912453-3d32e20f72bf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",20,false, Message(0,16,"","Chantal Reid")),
        Girl("Arlo Whitehead","Civil Engineer","https://images.unsplash.com/photo-1502898295-455afaf0f015?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",28,false, Message(0,17,"","Arlo Whitehead")),
        Girl("Addie Moreno","Clinical Laboratory Technician","https://images.unsplash.com/photo-1541971297127-c4e6f05297da?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",21,false, Message(0,18,"","Addie Moreno")),
        Girl("Tahmina Davies","Coach","https://images.unsplash.com/photo-1441123100240-f9f3f77ed41b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",24,false, Message(0,19,"","Tahmina Davies")),
        Girl("Selin Dalby","College Professor","https://images.unsplash.com/photo-1547147607-6eab7b49f3ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",25,false, Message(0,20,"","Selin Dalby")),
        Girl("Alyx Lu","Compliance Officer","https://images.unsplash.com/photo-1546052646-a88eafec0399?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",28,false, Message(0,21,"","Alyx Lu")),
        Girl("Kiera Le","Computer Hardware Engineer","https://images.unsplash.com/photo-1594058374296-33aa9cae524a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",25,false, Message(0,22,"","Kiera Le")),
        Girl("Amritpal Sellers","Computer Programmer","https://images.unsplash.com/photo-1566219094625-41fd3bc1ea5e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",21,false, Message(0,23,"","Amritpal Sellers")),
        Girl("Shaan Ashley","Computer Support Specialist","https://images.unsplash.com/photo-1596566263618-46778ebc6121?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",27,false, Message(0,24,"","Shaan Ashley")),
        Girl("Kloe Odonnell","Computer Systems Administrator","https://images.unsplash.com/photo-1583843364289-0d1b2978874c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",27,false, Message(0,25,"","Kloe Odonnell")),
        Girl("Poppy-Rose Oconnor","Computer Systems Analyst","https://images.unsplash.com/photo-1591361796603-01599a42e701?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",18,false, Message(0,26,"","Poppy-Rose Oconnor")),
        Girl("Collette Zavala","Construction Manager","https://images.unsplash.com/photo-1565699774381-d421d9e7ad41?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",27,false, Message(0,27,"","Collette Zavala")),
        Girl("Blanka Dyer","Cost Estimator","https://images.unsplash.com/photo-1587140029742-e23f5c300237?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",23,false, Message(0,28,"","Blanka Dyer")),
        Girl("Cian Rawlings","Court Reporter","https://images.unsplash.com/photo-1596815064285-45ed8a9c0463?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",23,false, Message(0,29,"","Cian Rawlings")),
        Girl("Lilly-Mai Barnard","Customer Service Representative","https://images.unsplash.com/photo-1552994281-1b25d423041c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",21,false, Message(0,30,"","Lilly-Mai Barnard")),
        Girl("Ira Whittaker","Dancer","https://images.unsplash.com/photo-1594745561149-2211ca8c5d98?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",21,false, Message(0,31,"","Ira Whittaker")),
        Girl("Shanae Dotson","Database administrator","https://images.unsplash.com/photo-1507229943010-31ed01024f05?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",23,false, Message(0,32,"","Shanae Dotson")),
        Girl("Lilly-May Grey","Dental Hygienist","https://images.unsplash.com/photo-1561997895-2e5d84cc3ac2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9",22,false, Message(0,33,"","Lilly-May Grey"))

    )

}
fun getALLGIRLSSHUFLED(): List<Girl> {
    return getGirlsAll().shuffled().subList(0,10)
}
package org.likelion.ohjeonggyu.liontestapp

import java.util.ArrayList

/**
 * Created by ohjeonggyu on 2017. 4. 1..
 */

object UserModel {


    val users: List<User>
        get() {
            val temp = ArrayList<User>()
            temp.add(User("홍길동", "02-111-1111", 25, "http://lostsaga-image.cdn.lostsaga.com/2014_grand/class/illust/thum_char_view_n_064.jpg"))
            temp.add(User("짱구", "02-111-222", 21, "http://cfile28.uf.tistory.com/image/274BC338559E609C23EE52"))
            temp.add(User("라이언", "02-111-3333", 11, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-dqh3x4svZo-NQR3MP1WleBcwz4zM6qHC5smGDvtXDf3SKUp6"))
            temp.add(User("이디야", "02-111-4444", 12, "http://cfile2.uf.tistory.com/image/2106753553F1511D1199EE"))
            temp.add(User("깃허브", "02-111-5555", 14, "https://assets-cdn.github.com/images/modules/open_graph/github-octocat.png"))


            return temp
        }


    class User(val name: String, val address: String, val age: Int, val image: String)
}

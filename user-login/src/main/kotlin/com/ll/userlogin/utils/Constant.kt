package com.ll.userlogin.utils

import java.util.*

class Constant {
    var JWT_ID : String = UUID.randomUUID().toString()
    var JWT_SECRET : String = "woyebuzhidaoxiediansha"
    var JWT_TTL : Int = 60*60*1000
}
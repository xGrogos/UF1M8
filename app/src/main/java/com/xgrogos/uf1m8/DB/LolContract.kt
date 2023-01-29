package com.xgrogos.uf1m8.DB

object LolContract {
    val table_name = "champions"
    val champion_name = "name"
    val champion_type = "type"
    val champion_description = "description"

    val SQL_CREATE_ENTRIES =
        "create table ${table_name} (" +
            "id integer primary key," +
            "${champion_name} text," +
            "${champion_type} text," +
            "${champion_description} text)"
    val SQL_DELETE_ENTRIES = "drop table if exists ${table_name}"
    val SQL_DELETE_ROWS = "delete from ${table_name}"
    val SQL_DELETE_BY_ID = "delete from ${table_name} where id = "
}
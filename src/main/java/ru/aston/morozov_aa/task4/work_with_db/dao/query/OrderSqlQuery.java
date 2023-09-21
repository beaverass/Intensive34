package ru.aston.morozov_aa.task4.work_with_db.dao.query;

public enum OrderSqlQuery {
    FIND_ALL("SELECT * FROM orders;"),
    FIND_BY_ID("SELECT * FROM orders WHERE id = ?;"),
    DELETE_BY_ID("DELETE FROM orders WHERE id = ?;"),
    CREATE("INSERT INTO orders(id, name, order_date, shipper_id) VALUES (?, ?, ?, ?);"),
    UPDATE("UPDATE orders SET name = ?, order_date = ?, shipper_id = ? WHERE id = ?;");

    private final String query;

    private OrderSqlQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}

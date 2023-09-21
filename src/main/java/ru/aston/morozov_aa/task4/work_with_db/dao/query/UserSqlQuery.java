package ru.aston.morozov_aa.task4.work_with_db.dao.query;

public enum UserSqlQuery {
    FIND_ALL("SELECT * FROM users;"),
    FIND_BY_ID("SELECT * FROM users WHERE id = ?;"),
    DELETE_BY_ID("DELETE FROM users WHERE id = ?;"),
    CREATE("INSERT INTO users (id, full_name, phone_number, email, birthday, order_id) VALUES (?, ?, ?, ?, ?, ?);"),
    UPDATE("UPDATE users SET full_name = ?, phone_number = ?, email = ?, birthday = ?, order_id = ? WHERE id = ?;"),
    JOIN_ORDERS_SHIPPERS("SELECT u.id AS user_id, full_name, email, o.name AS order_name, s.name AS shipper_name FROM users u INNER JOIN orders o ON u.order_id = o.id INNER JOIN shippers s ON o.shipper_id = s.id;");

    private final String query;

    private UserSqlQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}

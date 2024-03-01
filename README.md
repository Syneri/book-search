# book-search

Простой сервис с подключением к h2 db.

## Результаты теста
|Label       |# Samples|Average|Min|Max  |Std. Dev.|Error %|Throughput|Received KB/sec|Sent KB/sec|Avg. Bytes|
|------------|---------|-------|---|-----|---------|-------|----------|---------------|-----------|----------|
|HTTP Request|1000     |6100   |30 |11636|3240.31  |0.000% |68.38542  |6660.99        |8.34       |99741.4   |
|TOTAL       |1000     |6100   |30 |11636|3240.31  |0.000% |68.38542  |6660.99        |8.34       |99741.4   |

## Скриншоты
![Добавление книг](/about/app-books.png)

![Поиск книги](/about/app-search.png)

![jmeter запрос](/about/jmeter-request.png)

![jmeter результат](/about/jmeter-summary.png)

![jmeter график](/about/jmeter-graph.png)

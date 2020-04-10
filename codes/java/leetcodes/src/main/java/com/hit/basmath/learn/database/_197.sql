-- 197. Rising Temperature
--
-- Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.
--
-- +---------+------------------+------------------+
-- | Id(INT) | RecordDate(DATE) | Temperature(INT) |
-- +---------+------------------+------------------+
-- |       1 |       2015-01-01 |               10 |
-- |       2 |       2015-01-02 |               25 |
-- |       3 |       2015-01-03 |               20 |
-- |       4 |       2015-01-04 |               30 |
-- +---------+------------------+------------------+
--
-- For example, return the following Ids for the above Weather table:
--
-- +----+
-- | Id |
-- +----+
-- |  2 |
-- |  4 |
-- +----+

-- # Write your MySQL query statement below

select w1.id from weather w1, weather w2
where to_days(w1.RecordDate) = to_days (w2.RecordDate) + 1
and w1.Temperature > w2.Temperature;
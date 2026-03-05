INSERT INTO holidays(holiday_date, reason, holiday_type, created_at, created_by)
VALUES
    ('Jan 1',  'New Year''s Day',            'FESTIVAL', CURRENT_DATE, 'DBA'),
    ('Oct 31', 'Halloween',                  'FESTIVAL', CURRENT_DATE, 'DBA'),
    ('Nov 24', 'Thanksgiving Day',           'FESTIVAL', CURRENT_DATE, 'DBA'),
    ('Dec 25', 'Christmas',                  'FESTIVAL', CURRENT_DATE, 'DBA'),
    ('Jan 17', 'Martin Luther King Jr. Day', 'FEDERAL',  CURRENT_DATE, 'DBA'),
    ('July 4', 'Independence Day',           'FEDERAL',  CURRENT_DATE, 'DBA'),
    ('Sep 5',  'Labor Day',                  'FEDERAL',  CURRENT_DATE, 'DBA');
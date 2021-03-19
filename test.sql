/*select
a.userid,
a.email,
a.teamid,
b.score
*/
select
c.userid,
c.email,
c.teamid,
a.score
from
(
    select * from user_profile
)c
left join
(
    select * from leaderboard
) a
on a.teamid = c.teamid
left join
 (
    select 
    eventid,
    max(score) as score
    from leaderboard where score>=35
    group by eventid
)b
on a.score = b.score  and a.eventid = b.eventid
where a.score>=35
order by a.score desc,a.duration,c.userid 

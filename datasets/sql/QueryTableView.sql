select res."position", race.date as date, race."name" as race, circ."name" as circuit, circ.country, cons."name" as constructor, res.points, driv.forename, driv.surname
from results res, drivers driv, circuits circ, races race, constructors cons
where res.raceid = race.raceid
and res.driverid = driv.driverid
and res.constructorid = cons.constructorid
and race.circuitid = circ.id
order by date desc, position asc
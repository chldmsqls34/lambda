//오름차순정렬 (team테이블의 team_name스키마 정렬)
SELECT * FROM team ORDER BY team_name;

//중복제거나열(player테이블의 POSITION스키마 나열)
SELECT DISTINCT POSITION FROM player;

//포지션나열,중복제거하고포지션이없으면신입으로기재
SELECT DISTINCT IFNULL(NULLIF(POSITION,''),'신입') FROM player;

//수원팀 골키퍼 출력
SELECT * FROM player WHERE POSITION = 'GK' AND team_id = 'k02';

//수원팀 골키퍼의 이름 모두 출력 수원팀id=k02
SELECT player_name FROM player WHERE team_id = 'K02' AND POSITION = 'GK';

//수원팀에서 골기퍼의 이름을 모두 출력(id 모를 경우)
SELECT * FROM player WHERE POSITION = 'GK' AND team_id = (SELECT region_id FROM team WHERE team_name = '수원');

//수원팀에서 성이 고씨고 키170이상선수출력
SELECT * FROM player WHERE team_id = 'K02' AND player_name LIKE '고%' AND height>=170;


SELECT * FROM player WHERE height >= 170 AND team_id = (SELECT team_id FROM team t WHERE t.region_name = '수원';) AND player_name LIKE '고%';

//소속팀이 삼성블루윙즈이거나 드래곤즈에 소속된 선수들이어야 하고, 포지션이 미드필더(MF:Midfielder)이어야 한다.키는 170 센티미터 이상이고 180 이하여야 한다.
SELECT * FROM player WHERE height BETWEEN 170 AND 180 AND POSITION = 'MF'
                                 AND team_id = (SELECT team_id FROM team WHERE team_name ='삼성블루윙즈')OR team_id= (SELECT team_id FROM team WHERE team_name ='드래곤즈');

//수원을 연고지로 하는 골키퍼는 누구인가
SELECT player_name FROM player WHERE POSITION = 'GK' AND team_id =(SELECT team_id FROM team WHERE region_name = '수원');

//서울팀선수들 이름,키,몸무게 목록으로 출력하시오 키와몸무게가없으면()으로출력 키와몸무게는 내림차순으로정렬
SELECT DISTINCT
    player_name,
    IF(height IS NULL OR height = '', '0', height) AS height,
    IF(weight IS NULL OR weight = '', '0', weight) AS weight
    FROM player WHERE team_id =(SELECT team_id FROM team  WHERE region_name = '서울')
    ORDER BY height DESC, weight DESC;

//서울팀선수들이름과포지션과 키와몸무게와 각선수의bmi를 출력하시오 키와몸무게가없으면 "0"표시 bmi는 "NONE"으로 표시 결과는 이름내림차순정렬
SELECT DISTINCT
    player_name,
    POSITION,
    IF(height IS NULL OR height = '','0cm',CONCAT(height,'cm'))AS height,
    IF(weight IS NULL OR weight = '','0cm',CONCAT(weight,'kg'))AS weight,
    IF(height IS NOT NULL AND weight IS NOT NULL,
        ROUND(weight/((height/100)*(height/100)),2),'NONE')AS bmi
    FROM player WHERE team_id = (SELECT team_id FROM team WHERE region_name = '서울')
    ORDER BY player_name DESC;

    SELECT DISTINCT
            player_name,
            position,
            IF(height IS NULL OR height = '', '0cm', CONCAT(height, 'cm')) AS height,
            IF(weight IS NULL OR weight = '', '0kg', CONCAT(weight, 'kg')) AS weight,
            IF(height IS NOT NULL AND weight IS NOT NULL,
                ROUND(weight/((height/100)*(height/100)), 2), 'NONE') AS bmi
    FROM player
                JOIN team ON player.team_id = team.team_id
    WHERE team.region_name = '서울'
    ORDER BY player_name DESC;

//4개테이블 JOIN하기
SELECT * FROM stadium s JOIN team t ON s.stadium_id = t.stadium_id
                        JOIN player p ON t.team_id =  p.team_id
                        JOIN SCHEDULE sc ON s.stadium_id = sc.stadium_id

//수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK) 인 선수를 출력하시오
단 , 팀명, 선수명 오름차순 정렬하시오

SELECT team_name,player_name
FROM player p
JOIN team ON p.team_id = team.team_id
WHERE position = 'GK' and (p.team_id ='K02' or p.team_id= 'K10')
ORDER BY 1,2;


//팀과 연고지를 연결해서 출력하시오
[팀 명]             [홈구장]
수원[ ]삼성블루윙즈 수원월드컵경기장
SELECT CONCAT(t.region_name,'',t.team_name),stadium_name
FROM stadium s
JOIN team t ON s.stadium_id = t.stadium_id
WHERE t.region_name LIKE '수원%' AND s.stadium_name LIKE '수원%';


//수원팀(K02) 과 대전팀(K10) 선수들 중
키가 180 이상 183 이하인 선수들
키, 팀명, 사람명 오름차순
SELECT height,team_name,player_name
FROM player p
JOIN team ON p.team_id = team.team_id
WHERE height BETWEEN 180 AND 183 AND (p.team_id = 'K02' OR p.team_id = 'K10')
ORDER BY height,team_name,player_name;

//모든 선수들 중 포지션을 배정 받지 못한 선수들의
팀명과 선수이름 출력 둘다 오름차순
SELECT team_name,player_name
FROM player p
JOIN team t
ORDER BY 1,2;


//팀과 스타디움, 스케줄을 조인하여
2012년 3월 17일에 열린 각 경기의
팀이름, 스타디움, 어웨이팀 이름 출력
다중테이블 join 을 찾아서 해결하시오.
SELECT team_name HOME_TEAM,stadium_name,(SELECT team_name FROM team WHERE sc.awayteam_id = team_id )AWAY_TEAM
FROM stadium s
JOIN schedule sc ON s.stadium_id = sc.stadium_id
JOIN team t ON s.stadium_id = t.stadium_id
WHERE sc.sche_date = '20120317';

// 2012년 3월 17일 경기에
포항 스틸러스 소속 골키퍼(GK)
선수, 포지션,팀명 (연고지포함),
스타디움, 경기날짜를 구하시오
연고지와 팀이름은 간격을 띄우시오(수원[]삼성블루윙즈)
SELECT player_name,position,CONCAT(region_name,'',team_name),stadium_name
FROM stadium s
JOIN schedule sc ON s.stadium_id = sc.stadium_id
JOIN team t ON s.stadium_id = t.stadium_id
JOIN player p ON s.stadium_id = p.stadium_id
WHERE sc.sche_date = '20120317' AND s.position ='GK'
AND s.team_name = '포항 스틸러스';

SELECT player.player_name,
       player.position,
       CONCAT(team.region_name,' ', team.team_name) AS team_name,
       stadium.stadium_name,
       schedule.sche_date
FROM player
         JOIN team ON player.team_id = team.team_id
         JOIN stadium ON team.stadium_id = stadium.stadium_id
         JOIN schedule ON schedule.hometeam_id = team.team_id OR schedule.awayteam_id = team.team_id
WHERE schedule.sche_date = '20120317'
  AND player.position = 'GK'
  AND team.team_name = '스틸러스';

//홈팀이 3점이상 차이로 승리한 경기의
경기장 이름, 경기 일정
홈팀 이름과 원정팀 이름을 구하시오
SELECT stadium.stadium_name,
       schedule.sche_date,
       hometeam.team_name home_team_name,
       awayteam.team_name away_team_name
FROM schedule
         JOIN team hometeam ON schedule.hometeam_id = hometeam.team_id
         JOIN team awayteam ON schedule.awayteam_id = awayteam.team_id
         JOIN stadium ON hometeam.stadium_id = stadium.stadium_id
WHERE schedule.home_score - schedule.away_score >= 3;

SELECT s.stadium_name,
       sc.sche_date,
       (SELECT team_name FROM ) '홈팀',
       (SELECT team_name FROM)'원정팀'
FROM stadium s
         JOIN team t ON s.stadium_id = t.stadium_id
         JOIN schedule sc ON s.stadium_id = sc.stadium_id
WHERE sc.home_score - sc.away_score >= 3;



//STADIUM 에 등록된 운동장 중에서
홈팀이 없는 경기장까지 전부 나오도록
카운트 값은 19
힌트 : LEFT JOIN 사용해야함
경기장 이름, 홈팀 출력 없으면 null출력
SELECT s.stadium_name, t.team_name
FROM stadium s LEFT JOIN team t USING(stadium_id); - LEFT JOIN연습용

SELECT stadium_name, (SELECT t.team_name FROM team t WHERE t.stadium_id = st.stadium_id)
FROM stadium st;  - 스칼라서브쿼리

//플레이어 테이블에서 최상단 5개 로우를 출력
SELECT * FROM player LIMIT 5;

//(그룹바이: 집계함수 - 딱 5개 min, max, count, sum, avg)
평균키가 인천 유나이티스팀('K04')의 평균키  보다 작은 팀의
팀ID, 팀명, 평균키 추출
인천 유나이티스팀의 평균키 -- 176.59
키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에 포함되지 않도록 하세요.

SELECT t.team_id, t.team_name,
    round(AVG(p.height),2) AS average_height
FROM player p
         JOIN team t ON t.team_id = p.team_id
GROUP BY
    t.team_id, t.team_name
HAVING average_height < 176.59 /* 176.59 =  (SELECT AVG(height) FROM player WHERE team_id = 'K04')*/
order by average_height;


//포지션이 MF 인 선수들의 소속팀명 및  선수명, 백넘버 출력
SELECT t.team_name, p.player_name, p.back_no
FROM team t
JOIN player p ON t.team_id = p.team_id
WHERE p.POSITION = 'MF'
GROUP BY t.team_name, p.player_name, p.back_no;


//가장 키큰 선수 5명 소속팀명 및  선수명, 백넘버 출력, 단, 키  값이 없으면 제외

SELECT t.team_name,p.player_name,p.back_no,MAX(p.height) AS max_height
FROM team t
JOIN player p ON t.team_id = p.team_id
GROUP BY t.team_name,p.player_name,p.back_no
ORDER BY max_height DESC
LIMIT 5;


//선수 자신이 속한 팀의 평균키보다 작은  선수 정보 출력
(select round(avg(height),2) from player)

SELECT player_name,height,team_name
FROM player
JOIN team ON player.team_id = team.team_id
WHERE height < (SELECT AVG(height)
                       FROM player AS myteam
                       WHERE myteam.team_id = player.team_id
                       GROUP BY myteam.team_id);

SELECT p.*
FROM player p
JOIN (SELECT p2.team_id,ROUND(AVG(p2.height),2)avg
        FROM player p2
        WHERE p2.height != ''
        GROUP BY p2.team_id) t_avg USING(team_id)
WHERE p.height != ''
AND p.height < AVG;




//2012년 5월 한달간 경기가 있는 경기장  조회
SELECT stadium_name
FROM stadium s
JOIN schedule sc ON s.stadium_id = sc.stadium_id
WHERE sche_date BETWEEN 20120501 AND 20120531; /*LIKE '201205%'*/

/*(SELECT stadium_name from stadium s where sc.stadium_id = s.s.stadium_id) */

// 페이지네이션 로직을 위한 플레이어 테이블에서 최상단 로우를 출력
SELECT player_name FROM player
ORDER BY 1 LIMIT 0,5;

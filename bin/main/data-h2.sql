-- h2 DB는 메모리 DB라서 프로젝트 실행할때마다 데이터 리셋됨.. 
-- 테스트를 위해 자동 인서트하기 위해 만든 파일
insert into posts (title, author, content, created_date, modified_date) values ('테스트1', 'test1@gmail.com', '테스트1의 본문', now(), now());
insert into posts (title, author, content, created_date, modified_date) values ('테스트2', 'test2@gmail.com', '테스트2의 본문', now(), now());
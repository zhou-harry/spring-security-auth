Oauth2.0官方文档：https://oauth.net/2/

创建表：
```sql
TDROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(48) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--添加一条client记录（密码为：harry）,授权类型中如果没有加上：refresh_token则不会产生refresh_token的值
INSERT INTO oauth_client_details (client_id, client_secret, scope, authorized_grant_types, web_server_redirect_uri, autoapprove)
VALUES ('harry-client-id', '$2a$10$PFDpz98K3ROeSVImLkGhbe48OvF9oIvsheiPRzakIOzRs9nA3fjai', 'user_info', 'authorization_code,refresh_token', 'http://localhost:8083/login', 'user_info');
```
授权码访问路径：
```sh
http://localhost/oauth/authorize?
response_type=code
&client_id=harry-client-id
&scope=user_info
&redirect_uri=http://localhost:8083/login
```
授权码模式获取Token
```sh
http://localhost/oauth/token?
grant_type=authorization_code
&client_id=harry-client-id
&client_secret=harry
&redirect_uri=http://localhost:8083/login
&code=CKzhKS
```
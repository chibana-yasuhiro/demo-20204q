
# Use
-  Create Table

```

CREATE TABLE `user` (
    `id` int(10) unsigned not null AUTO_INCREMENT,
    `corporation_id` varchar(10) NOT NULL,
    `name` varchar(50) not null,
    `password` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

- Vue.js

```
cd demo-client
npm run serve
```

- Page
    - ユーザ新規登録
        `http://localhost:8080/user`

    - ログイン
        `http://localhost:8080/login`

    - Vue画面
        `http://localhost:8081/person`

# Explanation
spring securityのデフォルトのログイン機能をカスタマイズ
- CorporationPasswordAuthenticationFilter
    - UsernamePasswordAuthenticationFilterを拡張し、ログイン項目に法人IDを追加
- CorporationLoginConfiqurer
    - CorporationPasswordAuthenticationFilterを適用
- LoginAuthenticationProvider
    - AuthenticationProviderのauthenticateを独自実装
- SecurityConfiguration
    - CorporationLoginConfiqurerを適用
- node_modules
     - demo_client/配下のnode_modulesはgit管理から外している
     - `npm install`でpackage.jsonから必要なライブラリをダウンロードする
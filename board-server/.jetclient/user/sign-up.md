```toml
name = 'sign-up'
description = '유저 가입하기'
method = 'POST'
url = 'http://localhost:9001/users/sign-up'
sortWeight = 1000000
id = '0787719a-c831-44c6-9a2d-ca887444be84'

[[headers]]
key = 'Content-Type'
value = 'application/json'

[body]
type = 'JSON'
raw = '''
{
  "userId": "userId",
  "password": "password",
  "nickname": "nickname",
  "createdAt": ""
}'''
```

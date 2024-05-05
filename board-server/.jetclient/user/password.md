```toml
name = 'password'
description = '유저 비밀번호 변경'
method = 'PATCH'
url = 'http://localhost:9001/users/password'
sortWeight = 6000000
id = '8f25abf9-daed-49b4-af20-3832fd6be60a'

[[headers]]
key = 'Content-Type'
value = 'application/json'

[body]
type = 'JSON'
raw = '''
{
  "currentPassword": "password",
  "newPassword": "password2"
}'''
```

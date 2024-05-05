```toml
name = 'delete'
description = '유저 삭제'
method = 'POST'
url = 'http://localhost:9001/users/delete'
sortWeight = 7000000
id = '2b41930f-9700-4e1f-bf0c-ad4a36b137bf'

[[headers]]
key = 'Content-Type'
value = 'application/json'

[body]
type = 'JSON'
raw = '''
{
  "userId": "userId"
}'''
```

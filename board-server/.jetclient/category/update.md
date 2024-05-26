```toml
name = 'update'
method = 'PATCH'
url = 'http://localhost:9001/categories/update/6'
sortWeight = 2000000
id = '5bdd4142-da1e-44f4-b27d-afaa1a2da90b'

[[headers]]
key = 'Content-Type'
value = 'application/json'

[body]
type = 'JSON'
raw = '''
{
  "name": "경영지원",
  "sortStatus": "CATEGORIES",
  "searchCount": 0,
  "pagingStartOffset": 0
}'''
```

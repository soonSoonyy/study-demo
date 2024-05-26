```toml
name = 'register'
method = 'POST'
url = 'http://localhost:9001/categories/register'
sortWeight = 1000000
id = '6e4327fe-5296-4700-8955-c1f30d2064d7'

[[headers]]
key = 'Content-Type'
value = 'application/json'

[body]
type = 'JSON'
raw = '''
{
  "name": "디스플레이",
  "sortStatus": "CATEGORIES",
  "searchCount": 0,
  "pagingStartOffset": 0
}'''
```

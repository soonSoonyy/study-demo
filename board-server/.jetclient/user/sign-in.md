```toml
name = 'sign-in'
description = '유저  로그인'
method = 'POST'
url = 'http://localhost:9001/users/sign-in'
sortWeight = 2000000
id = '43f25b3b-a264-4a44-94ed-d11363e727d9'

[[headers]]
key = 'Content-Type'
value = 'application/json'

[body]
type = 'JSON'
raw = '''
{
  "userId": "asdf1234",
  "password": "asdf1234"
}'''
```

# Login

Used to collect a Token for a registered User.

**URL** : `/users/sign-in`

**Method** : `POST`

**Auth required** : NO

**Data constraints**

```json
{
    "userId": "[valid email address]",
    "password": "[password in plain text]"
}
```

**Data example**

```json
{
    "userId": "iloveauth",
    "password": "abcd1234"
}
```

## Success Response

**Code** : `200 OK`

**Content example**

```json
{
    "token": "93144b288eb1fdccbe46d6fc0f241a51766ecd3d"
}
```

## Error Response

**Condition** : If 'username' and 'password' combination is wrong.

**Code** : `400 BAD REQUEST`

**Content** :

```json
{
    "non_field_errors": [
        "Unable to login with provided credentials."
    ]
}
```
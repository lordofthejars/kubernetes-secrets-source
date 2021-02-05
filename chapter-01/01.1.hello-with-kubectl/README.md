# Install

To install do:

```sh
kubectl create -f .
```

Check the logs to see the loaded secrets:

```sh
> kubectl logs hello
db_host: "mydb.local"
db_username: "admin"
db_password: "supersecret"
```

# Uninstall

To uninstall do:

```sh
kubectl delete -f .
```

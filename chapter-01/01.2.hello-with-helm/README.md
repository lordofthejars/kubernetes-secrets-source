# Install

> Note: make sure previous examples are deleted before continuing

To install do:

```sh
helm install hello-tst charts/hello -f releases/values.tst.yaml
helm install hello-pre charts/hello -f releases/values.pre.yaml
helm install hello-pro charts/hello -f releases/values.pro.yaml
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
helm uninstall hello-tst
helm uninstall hello-pre
helm uninstall hello-pro
```
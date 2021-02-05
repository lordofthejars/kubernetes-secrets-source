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
# retrieve logs from hello-tst
> kubectl logs hello-tst
db_host: "mydb.tst.local"
db_username: "admin"
db_password: "supersecret-tst"

# retrieve logs from hello-pre
> kubectl logs hello-pre
db_host: "mydb.pre.local"
db_username: "admin"
db_password: "supersecret-pre"

# retrieve logs from hello-pro
> kubectl logs hello-pro
db_host: "mydb.pro.local"
db_username: "admin"
db_password: "supersecret-pro"
```

# Uninstall

To uninstall do:

```sh
helm uninstall hello-tst
helm uninstall hello-pre
helm uninstall hello-pro
```
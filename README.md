Embodied making website
=======================
[http://www.embodiedmaking.com](http://www.embodiedmaking.com)

* Explain our embodied making practice
* Document our method and some patterns
* Allow people to participate in our ventures


Testing locally
---------------
The application needs a locally configured environment to start. All required properties are in conf/application.conf. This can be done manually or with Heroku Toolbelt:

Create a local configuration in .env file based on server config

```bash
heroku plugins:install git://github.com/ddollar/heroku-config.git
heroku config:pull --overwrite --interactive
```

Create a Procfile
```bash
echo "web: play run \$PLAY_OPTS" > Procfile
```


Now start the application using foreman

```bash
foreman start
```

Facebook login
--------------

To test Facebook login locally, we need to use the correct hostname. Add the following line to /etc/hosts

```
127.0.0.1       local.embodiedmaking.com
```

The page is now available at http://local.embodiedmaking.com:9000/
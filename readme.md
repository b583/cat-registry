# Cat Registry
Small Dropwizard application done to illustrate some ideas on how to handle Java 9 modules.

## Running the application

Create a *config.yaml* file with following contents:
```yaml
shouldRegisterNotNiceKitties: false
```
Start CatRegistryMainApplication with arguments
``server config.yaml``.
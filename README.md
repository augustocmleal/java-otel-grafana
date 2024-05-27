## About The Project

Simple implementation example of Observability with Java



### Built With

* Java
* Open Telemetry
* Prometheus
* Grafana Cloud

## Getting Started

### Prerequisites
* JDK 17
* Grafana cloud account (it works in trial tier)

### Environment Variables
To run the project you need to setup some enviroment variables:

```
 JAVA_TOOL_OPTIONS=-javaagent:opentelemetry-javaagent.jar;
 OTEL_JAVAAGENT_DEBUG=true; (optional)
 OTEL_LOGS_EXPORTER=none;
 OTEL_METRICS_EXPORTER=prometheus;
 OTEL_TRACES_EXPORTER=none;
 OTEL_EXPORTER_PROMETHEUS_PORT=9090;
 OTEL_EXPORTER_PROMETHEUS_HOST=localhost
```
### Prometheus Configuration
Setup prometheus.yml file with your grafana cloud informations. (pushUrl, user and token)

``` yml
global:
  scrape_interval: 60s
remote_write:
  - url: grafanaCloudPrometheusPushUrl
    basic_auth:
      username: grafanaCloudUser
      password: grafanaCloudUserToken
scrape_configs:
  - job_name: node
    static_configs:
      - targets: ["localhost:9090"]
```

## Run
### Prometheus
Run the docker image from prometheus
``` cmd
  docker compose up
```
_The image is set to run prometheus in degub mode. You can disable it removing the --log.level=debug attribute in the docker compose file_

### Java Application
Run the springboot project in your ide.

### Grafana
Open your grafana cloud.

On the left menu go to "Explore" option
Select a metric to show the graph (ex: go_memstats_frees_total)

## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

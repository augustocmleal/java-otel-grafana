# STATUS: IN PROGRESS

## About The Project

Simple implementation example of Observability with Java

### Built With

* Java
* Open Telemetry
* Prometheus
* Grafana

## Getting Started

### Prerequisites
* JDK 17
* Grafana cloud account (it works in trial tier)

### Environment Variables
To run the project you need to setup some enviroment variables:

```
 JAVA_TOOL_OPTIONS=-javaagent:opentelemetry-javaagent.jar;
 OTEL_SERVICE_NAME=java-opentelemetry-service;
 OTEL_LOGS_EXPORTER=none;
 OTEL_METRICS_EXPORTER=prometheus;
 OTEL_TRACES_EXPORTER=otlp;
 OTEL_EXPORTER_PROMETHEUS_PORT=9464;
 OTEL_EXPORTER_PROMETHEUS_HOST=localhost
```
### Prometheus Configuration
Setup prometheus.yml file.

``` yml
global:
  scrape_interval: 60s
scrape_configs:
  - job_name: myApplicationServiceName
    static_configs:
      - targets: ["host.docker.internal:9464"]
```

## Run
### Prometheus + Jaeger + Grafana
Run the docker to containers up
``` cmd
  docker compose up
```

#### Access urls:
- Prometheus: http://localhost:9090
- Jaeger:  http://localhost:16686
- Grafana: http://localhost:4000

### Java Application
Run the springboot project in your ide.


## Grafana Setup
Open grafana (http://localhost:3000)

    user: admin
    pwd: admin

### Metrics configuration
- Expand "Connections" dropdown then select "Add new connection" option on the left side menu
- Type Prometheus in the search bar
- Select Prometheus option
- Click on "Add New Datasource" button on the right top
- Add in "Prometheus server URL" input box:
```
http://prometheus:9090
```
- Roll down and click on "Save and Test" button

### Traces configuration
- Expand "Connections" dropdown then select "Add new connection" option on the left side menu
- Type Jaeger in the search bar
- Select Jaeger option
- Click on "Add New Datasource" button on the right top
- Add in "Jaeger server URL" input box:
```
http://jaeger:16686
```
- Roll down and click on "Save and Test" button

## Results

### Metrics
- On the left side menu expand "Explore" dropdown then select "Metrics" option to see the metrics.

### Traces
- Select the "Explore" option on the left side menu
- Select "Jaeger" option on the select box
- Select what service name you want to show the traces
- Click on "Run Query" button to execute search
- Click at the trace you want to see the details

## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

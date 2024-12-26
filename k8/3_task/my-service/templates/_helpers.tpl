{{/*
Generate a label for the current date.
*/}}
{{- define "my-app.labels.currentDate" -}}
currentDate: "{{ now | date "2006-01-02_15-04-05" }}"
{{- end }}

{{/*
Generate a label for the version, pulling it from Chart.yaml.
*/}}
{{- define "my-app.labels.version" -}}
version: "{{ .Chart.Version }}"
{{- end }}

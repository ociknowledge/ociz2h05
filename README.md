# OCI Zero To Hero Chapter 5
Ejemplo desarrollado en Spring Boot para mostrar el uso de VPN en OCI. Estos comandos están realizados para distribuciones Oracle Linux, CentOS y Red Hat. 

```console
sudo dnf install java
sudo firewall-cmd --list-ports
sudo firewall-cmd --zone=public --add-port=8080/tcp --permanent
sudo firewall-cmd --reload
wget https://github.com/ociknowledge/ociz2h05/releases/download/v1.0.0/z2h.jar
```

Los siguientes pasos los debemos ejecutar como root.

```console
sudo -su root
sudo cat <<EOF > /etc/systemd/system/z2h.service
[Unit]
Description=Spring Boot WebApp for From Zero To Hero

[Service]
Type=simple
Restart=on-failure
User=opc
ExecStart=/usr/java/default/bin/java -jar /home/opc/z2h.jar

[Install] 
WantedBy=multi-user.target
EOF
```

Por último, sobre el usuario por defecto realizamos los siguientes comandos.

```console
sudo systemctl daemon-reload
sudo systemctl enable --now z2h
sudo systemctl status z2h
```
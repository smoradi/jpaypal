# JPaypal Micro Service
#
# This is a simple micro service installable in your FreeBSD server.
# Which serves Paypal-rest-sdk functionality such as create payment,
# execute payment and refund a payment.
#
# You may find using com.paypal.sdk:rest-api-sdk:x.x.x.jar directly
# in your application easier and simpler, then is better to use it directly.
#
# But if you prefer to use Paypal-rest-api-sdk in one corner and reuse
# It's functionality through HTTP protocol or
# If you want to connect to Paypal rest api through proxy server and
# your java process also needs to be configured for example with below
# parameters:
# -Dhttps.proxyHost=localhost -Dhttps.proxyPort=8118 \
#  -Dhttp.proxyHost=localhost -Dhttp.proxyPort=8118 \
#  -DsocksProxyHost=localhost -DsocksProxyPort=9050 \
#
# then you may find this micro service useful.
# see INSTALL.txt for installation.

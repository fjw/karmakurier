# Part 1: Docker will build a PROD-ready version of the (Vue.js)WebApp
FROM node:12.13.1-alpine AS builder

RUN mkdir -p /app
WORKDIR /app

# Install all used packages
COPY *.json ./
RUN npm install

RUN npm install -g @vue/cli
COPY . /app
# Build the WebApp
RUN npm run build

# Part 2: Docker will build the Nginx image with the (Vue.js)WebApp
FROM nginx:1.16.1-alpine

# Copy the WebApp files
COPY --from=builder /app/dist /usr/share/nginx/html

# Copy some Nginx related files
COPY ./docker/nginx-http-error.html /usr/share/nginx/html
COPY ./docker/nginx-vhost.conf /etc/nginx/conf.d/default.conf

#Setup SSL/TLS/HTTPS for Nginx
RUN mkdir /etc/nginx/ssl
RUN chmod 700 /etc/nginx/ssl
COPY ./docker/ssl/karmakurier-org.crt /etc/nginx/ssl/
COPY ./docker/ssl/karmakurier-org.key /etc/nginx/ssl/

EXPOSE 80 443
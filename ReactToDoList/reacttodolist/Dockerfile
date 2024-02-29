# FROM node:13.12.0-alpine

# WORKDIR /reactdocker

# COPY package.json package-lock.json ./
# RUN npm install

# COPY . ./

# CMD ["npm", "run", "docker-start"]


#

FROM node:16-alpine AS builder
WORKDIR /reactdocker
COPY package.json package-lock.json ./
RUN npm install

COPY . .
RUN npm run build

FROM nginx
RUN rm /etc/nginx/conf.d/default.conf
RUN rm -rf /etc/nginx/conf.d/*
COPY nginx/nginx.conf /etc/nginx/conf.d

COPY --from=builder /reactdocker/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]


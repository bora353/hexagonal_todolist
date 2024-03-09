# FROM node:16-alpine

# Run mkdir /reactdocker
# WORKDIR /reactdocker

# ENV PATH /reactdocker/node_modules/.bin:$PATH

# COPY package.json /app/package.json
# RUN npm install

# CMD ["npm", "start"]


#
# as builder 사용하면 밑에서 다시 사용 가능
FROM node:16-alpine AS builder 
WORKDIR /reactdocker
COPY package*.json ./
RUN npm install

COPY . .

# npm build
RUN npm run build



FROM nginx:stable-alpine

# 이전 빌드 단계에서 빌드한 결과물을 /usr/share/nginx/html 으로 복사한다.
COPY --from=builder /reactdocker/build /usr/share/nginx/html

# 기본 nginx 설정 파일을 삭제한다. (custom 설정과 충돌 방지)
RUN rm /etc/nginx/conf.d/default.conf
RUN rm -rf /etc/nginx/conf.d/*

# custom 설정파일을 컨테이너 내부로 복사한다.
COPY nginx/nginx.conf /etc/nginx/conf.d

# 컨테이너의 80번 포트를 열어준다.
EXPOSE 80

# nginx 서버를 실행하고 백그라운드로 동작하도록 한다.
CMD ["nginx", "-g", "daemon off;"]


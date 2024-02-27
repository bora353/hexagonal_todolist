FROM node:13.12.0-alpine

WORKDIR /reactdocker

COPY package.json package-lock.json ./
RUN npm install

COPY . ./
#COPY build/ ./build/

CMD ["npm", "run", "docker-start"]
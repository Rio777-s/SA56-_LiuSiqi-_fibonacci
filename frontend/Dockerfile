FROM node:16.18-alpine3.16

#[HOST MACHINE] []
COPY package.json package-lock.json .

RUN npm install

COPY . .

RUN npm run build

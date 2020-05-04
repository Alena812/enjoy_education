from django.shortcuts import render
from rest_framework import viewsets
from rest_framework.decorators import action
from rest_framework.response import Response
from .serializers import *
from .models import *


class CoursesViewSet(viewsets.ModelViewSet):
    serializer_class = CourseSerializer
    queryset = Course.objects.all()

    @action(methods=['get'], detail=True)  # add permission classes
    def my_courses(self, request, pk=None):
        queryset = Course.objects.filter(creator=self.request.user)
        serializer = CourseSerializer(queryset, many=True)
        return Response(serializer.data, status=200)


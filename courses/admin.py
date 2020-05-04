from django.contrib import admin
from .models import Course, Lesson


class CourseAdmin(admin.ModelAdmin):
    list_display = ('id', 'title')


class LessonAdmin(admin.ModelAdmin):
    list_display = ('id', 'short_info', 'is_valid', 'course')


admin.site.register(Course, CourseAdmin)
admin.site.register(Lesson, LessonAdmin)
